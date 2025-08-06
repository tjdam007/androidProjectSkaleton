package com.example.androidprojectskaleton.data.repository

import com.example.androidprojectskaleton.data.api.ApiService
import com.example.androidprojectskaleton.data.model.Post
import com.example.androidprojectskaleton.util.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getPosts(): List<Post> = withContext(Dispatchers.IO) {
        try {
            Logger.d("Fetching posts from API")
            val posts = apiService.getPosts()
            Logger.i("Successfully fetched ${posts.size} posts")
            posts
        } catch (e: Exception) {
            Logger.e(e, "Error fetching posts from API")
            emptyList()
        }
    }

    suspend fun getPost(id: Int): Post? = withContext(Dispatchers.IO) {
        try {
            Logger.d("Fetching post with ID: $id")
            val post = apiService.getPost(id)
            Logger.i("Successfully fetched post: ${post.title}")
            post
        } catch (e: Exception) {
            Logger.e(e, "Error fetching post with ID: $id")
            null
        }
    }
} 