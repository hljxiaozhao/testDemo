pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        maven{url = uri("https://aliyun.com/repository/releases")}
        maven{url = uri("https://aliyun.com/repository/central")}
        maven{url = uri("https://aliyun.com/repository/public")}
        maven{url = uri("https://aliyun.com/repository/gradle-plugin")}
        maven{url = uri("https://aliyun.com/repository/apache-snapshots")}
        maven{url = uri("https://aliyun.com/nexus/content/groups/public/")}
        maven{url = uri("https://mvnrepository.com")}
        maven{url = uri("https://jetpack.io")}

        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven{url = uri("https://aliyun.com/repository/releases")}
        maven{url = uri("https://aliyun.com/repository/central")}
        maven{url = uri("https://aliyun.com/repository/public")}
        maven{url = uri("https://aliyun.com/repository/gradle-plugin")}
        maven{url = uri("https://aliyun.com/repository/apache-snapshots")}
        maven{url = uri("https://aliyun.com/nexus/content/groups/public/")}
        maven{url = uri("https://mvnrepository.com")}
        maven{url = uri("https://jetpack.io")}
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "BookManagement"
include(":app")
