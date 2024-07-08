pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        maven {
            url = uri("http://oss.sonatype.org/content/repositories/snapshots")
            isAllowInsecureProtocol = true
        }
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")
        }

        maven {
            url = uri("http://oss.sonatype.org/content/repositories/snapshots")
            isAllowInsecureProtocol = true
        }
    }
}

rootProject.name = "Piano Companion OMR"
include(":app")
 