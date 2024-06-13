pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
//// //       if using release
//        maven { url = uri("https://www.jitpack.io") }
// //       if using bar
//        maven {
//            url = uri("https://maven.pkg.github.com/FredyWise/Simple-Calculator")
//            credentials {
//                username = System.getenv("GITHUB_USERNAME")
//                password = System.getenv("GITHUB_TOKEN")
//            }
//        }
    }
}

rootProject.name = "Simple-Calculator"
include(":app")
include(":BusinessCalculator")
