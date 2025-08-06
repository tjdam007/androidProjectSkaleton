# Android Project Skeleton

A modern Android project skeleton with all the latest tools and libraries for building robust Android applications.

## 🚀 Features

### Core Technologies
- **Kotlin** with **Gradle KTS** build scripts
- **Version Catalog** for centralized dependency management
- **Jetpack Compose** for modern UI development
- **Material Design 3** with extended icons

### Architecture & Dependency Injection
- **Hilt** for dependency injection
- **MVVM** architecture pattern
- **Repository pattern** with Room database

### Networking & Data
- **OkHttp BOM** for HTTP networking
- **Room** with **KSP** for local database
- **Coil** for efficient image loading

### UI/UX
- **Shimmer** for loading states
- **Material Icons Extended** for rich iconography
- **Compose BOM** for consistent Compose versions

### Analytics & Monitoring
- **Firebase BOM** for analytics and crash reporting
- **Google Analytics** integration
- **Crashlytics** for crash monitoring

## 📁 Project Structure

```
androidProjectSkaleton/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/androidprojectskaleton/
│   │   │   ├── data/
│   │   │   │   ├── dao/          # Room DAOs
│   │   │   │   ├── database/     # Room database
│   │   │   │   └── entity/       # Room entities
│   │   │   ├── di/               # Hilt modules
│   │   │   ├── ui/theme/         # Compose theme
│   │   │   ├── AndroidProjectSkaletonApp.kt
│   │   │   ├── MainActivity.kt
│   │   │   ├── MainScreen.kt
│   │   │   └── MainViewModel.kt
│   │   ├── res/                  # Resources
│   │   └── AndroidManifest.xml
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── gradle/
│   └── libs.versions.toml        # Version Catalog
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## 🛠 Setup Instructions

### Prerequisites
- Android Studio Hedgehog or later
- JDK 17 or later
- Android SDK 34

### Getting Started

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd androidProjectSkaleton
   ```

2. **Configure Firebase** (Optional)
   - Replace `app/google-services.json` with your Firebase configuration
   - Update the Firebase project ID in the configuration

3. **Build the project**
   ```bash
   ./gradlew build
   ```

4. **Run the app**
   ```bash
   ./gradlew installDebug
   ```

## 📦 Dependencies

### Version Catalog Management
All dependencies are managed through the Version Catalog in `gradle/libs.versions.toml`:

- **SDK Versions**: compileSdk, targetSdk, minSdk
- **App Versions**: versionCode, versionName
- **Library Versions**: All library versions are centralized
- **BOMs**: Firebase, Compose, OkHttp BOMs for version consistency

### Key Libraries

#### UI & Navigation
- `androidx.compose.bom` - Compose BOM
- `androidx.navigation.compose` - Navigation
- `com.google.android.material` - Material Design
- `com.facebook.shimmer` - Loading animations

#### Networking & Data
- `com.squareup.okhttp3:okhttp-bom` - HTTP client
- `androidx.room:room-runtime` - Local database
- `io.coil-kt:coil-compose` - Image loading

#### Dependency Injection
- `com.google.dagger:hilt-android` - Hilt DI
- `androidx.hilt:hilt-navigation-compose` - Hilt + Compose

#### Analytics & Monitoring
- `com.google.firebase:firebase-bom` - Firebase BOM
- `com.google.firebase:firebase-analytics` - Analytics
- `com.google.firebase:firebase-crashlytics` - Crash reporting

## 🔧 Configuration

### Version Catalog
The `gradle/libs.versions.toml` file contains:
- All version definitions
- Library declarations
- Plugin configurations
- Dependency bundles

### Build Configuration
- **Kotlin**: 1.9.20
- **Compose Compiler**: 1.5.4
- **Android Gradle Plugin**: 8.1.4
- **KSP**: 1.9.20-1.0.14

### ProGuard Rules
Includes optimized ProGuard rules for:
- Room database
- Hilt dependency injection
- Firebase services
- OkHttp networking
- Coil image loading
- Shimmer animations

## 🎨 UI Components

### Example Usage
The project includes example implementations of:
- **Material 3** components
- **Extended icons** from Material Design
- **Shimmer loading** states
- **Coil image loading**
- **Navigation** with bottom navigation
- **Hilt ViewModels** with state management

## 🚀 Next Steps

1. **Replace Firebase Configuration**
   - Update `google-services.json` with your project
   - Configure Firebase Analytics and Crashlytics

2. **Customize Theme**
   - Modify colors in `Color.kt`
   - Update typography in `Type.kt`

3. **Add Features**
   - Implement your business logic
   - Add more screens and navigation
   - Integrate with your APIs

4. **Testing**
   - Add unit tests for ViewModels
   - Add UI tests for Compose screens
   - Configure test dependencies

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

---

**Happy Coding! 🎉** 