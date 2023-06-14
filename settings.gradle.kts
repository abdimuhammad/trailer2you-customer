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
    }
}
rootProject.name = "Trailer2You Customer"
include ("app")

include(":core:model")
include(":core:network")
include(":core:common")
include(":core:database")
include(":core:datastore")
include(":core:domain")
