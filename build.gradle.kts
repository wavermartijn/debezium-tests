
plugins {

}

configurations.all {
    // Turn off cache for SNAPSHOT dependencies
    resolutionStrategy.cacheChangingModulesFor(0, TimeUnit.SECONDS)

}
