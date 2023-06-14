package apps.trailer2you.database

class NativeLib {

    /**
     * A native method that is implemented by the 'database' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'database' library on application startup.
        init {
            System.loadLibrary("database")
        }
    }
}