#!/bin/bash

# Android Project Skeleton - Build Flavors Script

echo "🚀 Android Project Skeleton - Build Flavors"
echo "=========================================="

case "$1" in
    "dev")
        echo "📱 Building DEV flavor..."
        ./gradlew assembleDevDebug
        echo "✅ DEV build completed!"
        ;;
    "staging")
        echo "📱 Building STAGING flavor..."
        ./gradlew assembleStagingDebug
        echo "✅ STAGING build completed!"
        ;;
    "production")
        echo "📱 Building PRODUCTION flavor..."
        ./gradlew assembleProductionRelease
        echo "✅ PRODUCTION build completed!"
        ;;
    "all")
        echo "📱 Building ALL flavors..."
        ./gradlew assembleDevDebug
        ./gradlew assembleStagingDebug
        ./gradlew assembleProductionRelease
        echo "✅ ALL builds completed!"
        ;;
    *)
        echo "Usage: $0 {dev|staging|production|all}"
        echo ""
        echo "Available flavors:"
        echo "  dev        - Development build with logging enabled"
        echo "  staging    - Staging build with logging enabled"
        echo "  production - Production build with logging disabled"
        echo "  all        - Build all flavors"
        echo ""
        echo "Examples:"
        echo "  $0 dev"
        echo "  $0 staging"
        echo "  $0 production"
        echo "  $0 all"
        exit 1
        ;;
esac 