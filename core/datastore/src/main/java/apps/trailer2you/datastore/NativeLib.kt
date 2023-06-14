package apps.trailer2you.datastore

class NativeLib {

    /**
     * A native method that is implemented by the 'datastore' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'datastore' library on application startup.
        init {
            System.loadLibrary("datastore")
        }
    }
}