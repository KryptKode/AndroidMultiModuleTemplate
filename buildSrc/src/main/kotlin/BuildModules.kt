/**
 * Configuration of build modules
 */
object BuildModules {
    const val app = ":app"
    const val core = ":core"

    object Features {
        const val home = ":features:home"
    }

    object Commons {
        const val testShared = ":common:testShared"
        const val androidShared = ":common:androidShared"
    }
}
