# Android Project Skeleton

A comprehensive Android project skeleton with modern development tools and libraries.

## Features Included

### ✅ Core Technologies
- **Kotlin** with Gradle KTS
- **Version Catalog** for dependency management
- **Jetpack Compose** for modern UI development
- **Material Design 3** with Material You theming

### ✅ Architecture & Dependency Injection
- **Hilt** for dependency injection
- **MVVM Architecture** with ViewModels
- **Repository Pattern** for data management

### ✅ Networking & Data
- **Retrofit** for HTTP networking
- **OkHttp** with logging interceptor
- **Moshi** for JSON serialization/deserialization
- **Kotlin Serialization** for type-safe JSON handling
- **Coroutines** for asynchronous programming

### ✅ Database
- **Room** with KSP for local database
- **Kotlin Coroutines** for database operations

### ✅ UI & Animations
- **Coil** for image loading
- **Shimmer** for loading states
- **Material Icons** (Core & Extended)
- **Lottie** for animations (ready to use)

### ✅ Logging & Build Flavors
- **Timber** for structured logging
- **Build Flavors** (dev, staging, production)
- **Environment-specific** configurations
- **Conditional logging** based on build type

### ✅ Firebase Integration
- **Firebase BOM** for consistent versions
- **Firebase Analytics**
- **Firebase Crashlytics**

### ✅ Testing
- **JUnit** for unit testing
- **Espresso** for UI testing
- **Compose Testing** utilities

## Project Structure

```
app/src/main/java/com/example/androidprojectskaleton/
├── data/
│   ├── api/
│   │   └── ApiService.kt          # Retrofit API interface
│   ├── model/
│   │   └── Post.kt                # Data models with Moshi annotations
│   ├── repository/
│   │   └── PostRepository.kt      # Repository pattern implementation
│   ├── dao/
│   │   └── UserDao.kt             # Room DAO
│   ├── database/
│   │   └── AppDatabase.kt         # Room database
│   └── entity/
│       └── User.kt                # Room entities
├── di/
│   ├── DatabaseModule.kt          # Hilt database module
│   └── NetworkModule.kt           # Hilt network module
├── ui/
│   └── theme/                     # Material 3 theming
├── MainActivity.kt
├── MainScreen.kt                  # Compose UI
├── MainViewModel.kt               # MVVM ViewModel
└── AndroidProjectSkaletonApp.kt   # Application class
```

## Key Dependencies

### Networking
- `retrofit` - HTTP client
- `retrofit-converter-moshi` - JSON serialization
- `okhttp` - HTTP client library
- `okhttp-logging-interceptor` - Network logging

### Serialization
- `moshi` - JSON serialization
- `moshi-kotlin` - Kotlin support for Moshi
- `kotlinx-serialization-json` - Kotlin serialization

### Coroutines
- `kotlinx-coroutines-core` - Coroutines core
- `kotlinx-coroutines-android` - Android coroutines

### Logging
- `timber` - Structured logging library

### UI Components
- `coil-compose` - Image loading
- `shimmer` - Loading animations
- `lottie-compose` - Lottie animations

## Usage Examples

### API Service with Retrofit & Moshi
```kotlin
@JsonClass(generateAdapter = true)
data class Post(
    @Json(name = "id") val id: Int,
    @Json(name = "title") val title: String,
    @Json(name = "body") val body: String
)

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}
```

### Repository Pattern with Coroutines
```kotlin
@Singleton
class PostRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getPosts(): List<Post> = withContext(Dispatchers.IO) {
        apiService.getPosts()
    }
}
```

### ViewModel with StateFlow
```kotlin
@HiltViewModel
class MainViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()
    
    fun loadPosts() {
        viewModelScope.launch {
            val posts = postRepository.getPosts()
            _uiState.value = _uiState.value.copy(posts = posts)
        }
    }
}
```

### Compose UI with Shimmer Loading
```kotlin
@Composable
fun LoadingCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .shimmer()
    )
}
```

### Structured Logging with Timber
```kotlin
// Initialize in Application class
Logger.init()

// Usage throughout the app
Logger.d("Debug message")
Logger.i("Info message")
Logger.e("Error message", exception)
```

## Build Flavors

The project includes three build flavors:

### 🚀 Development (dev)
- **Application ID**: `com.example.androidprojectskaleton.dev.debug`
- **Logging**: Enabled
- **Features**: Full debugging capabilities
- **Build Command**: `./gradlew assembleDevDebug`

### 🧪 Staging (staging)
- **Application ID**: `com.example.androidprojectskaleton.staging.debug`
- **Logging**: Enabled
- **Features**: Production-like environment
- **Build Command**: `./gradlew assembleStagingDebug`

### 🏭 Production (production)
- **Application ID**: `com.example.androidprojectskaleton`
- **Logging**: Disabled
- **Features**: Optimized for release
- **Build Command**: `./gradlew assembleProductionRelease`

### 📱 Quick Build Commands
```bash
# Build specific flavors
./build-flavors.sh dev
./build-flavors.sh staging
./build-flavors.sh production

# Build all flavors
./build-flavors.sh all
```

## Getting Started

1. Clone the repository
2. Open in Android Studio
3. Sync Gradle files
4. Choose your build flavor (dev/staging/production)
5. Run the app

The app demonstrates:
- API calls with Retrofit
- JSON serialization with Moshi
- Coroutines for async operations
- Shimmer loading states
- Material 3 theming
- Hilt dependency injection

## Notes

- **Pull to Refresh**: Currently using a placeholder. For production, consider using `accompanist-swiperefresh` or implementing custom pull-to-refresh
- **Lottie**: Ready to use - just add your Lottie JSON files to `res/raw/`
- **Network Security**: Add network security config for production apps
- **Error Handling**: Implement proper error handling for production use
- **Firebase**: Currently disabled for demo. Uncomment in `app/build.gradle.kts` when Firebase is configured
- **Logging**: Timber logging is enabled for dev/staging and disabled for production builds

## License

This project is open source and available under the [MIT License](LICENSE). 