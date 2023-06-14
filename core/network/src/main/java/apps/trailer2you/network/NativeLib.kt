package apps.trailer2you.network

class NativeLib {

    /**
     * A native method that is implemented by the 'network' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'network' library on application startup.
        init {
            System.loadLibrary("network")
        }
    }
}