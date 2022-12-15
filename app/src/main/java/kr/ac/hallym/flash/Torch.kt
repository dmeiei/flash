package kr.ac.hallym.flash

import android.content.Context
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.annotation.RequiresApi

class Torch(context: Context) {
    private var cameraId: String? = null
    private val cameraManager = context.getSystemService(Context.CAMERA_SERVICE)as CameraManager

    init {
        cameraId = getCameraId()
    }
    @RequiresApi(Build.VERSION_CODES.M)
    fun flashOn(){
        if(cameraId != null) cameraManager.setTorchMode(cameraId!!,true)
    }
    @RequiresApi(Build.VERSION_CODES.M)
    fun flashoff(){
        if(cameraId != null) cameraManager.setTorchMode(cameraId!!,false)
    }

    private fun getCameraId():String?{
        val cameraIds = cameraManager.cameraIdList
        for(id in cameraIds){
            val info = cameraManager.getCameraCharacteristics(id)
            val flashAvailable = info.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)
            val lensFacing = info.get(CameraCharacteristics.LENS_FACING)
            if(flashAvailable != null && flashAvailable && (lensFacing != null) && (lensFacing > 0)&& lensFacing == CameraCharacteristics.LENS_FACING_BACK){
                return id
            }
        }
        return null
    }
}