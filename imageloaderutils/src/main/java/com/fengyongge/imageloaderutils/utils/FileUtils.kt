package com.fengyongge.imageloaderutils.utils

import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.os.Environment
import com.fengyongge.imageloaderutils.utils.NotifyUtils.Companion.refreshSystemPic
import java.io.*

/**
 * describe
 *
 * @author fengyongge
 * @data 2020/11/2
 */
class FileUtils {

    companion object {
        /**
         * 创建需要保存的文件
         * @param isUseExternalFilesDir 是否使用getExternalFilesDir,false为保存在sdcard根目录下
         * @param fileName 保存文件名
         * @param folderName 保存在sdcard根目录下的文件夹名（isUseExternalFilesDir=false时需要）
         */

        @JvmStatic
        fun savaFileUtils(
                context: Context,
                isUseExternalFilesDir: Boolean,
                fileName: String,
                folderName: String = ""
        ): File {
            val filePath = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                context.getExternalFilesDir(folderName)?.absolutePath!!
            } else {
                if (isUseExternalFilesDir) {
                    context.getExternalFilesDir(folderName)?.absolutePath!!
                } else {
                    Environment.getExternalStorageDirectory().absolutePath
                }
            }
            return if (isUseExternalFilesDir) {
                File(filePath, fileName)
            } else {
                val file = File(filePath, folderName!!)
                if (!file.exists()) {
                    file.mkdirs()
                }
                File(file, fileName)
            }
        }


        /**
         * bitmap保存到File
         */
        @JvmStatic
        fun saveBitmap2File(
                context: Context,
                bitmap: Bitmap,
                file: File
        ) {
            try {
                val fos = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
                fos.flush()
                fos.close()
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            //通知系统图库更新
            refreshSystemPic(context, file)
        }

        /**
         * 复制文件
         *
         * @param source 输入文件
         * @param target 输出文件
         */
        @JvmStatic
        fun copy(source: File?, target: File?) {
            var fileInputStream: FileInputStream? = null
            var fileOutputStream: FileOutputStream? = null
            try {
                fileInputStream = FileInputStream(source)
                fileOutputStream = FileOutputStream(target)
                val buffer = ByteArray(1024)
                while (fileInputStream.read(buffer) > 0) {
                    fileOutputStream.write(buffer)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                try {
                    source?.delete()
                    fileInputStream?.close()
                    fileOutputStream?.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
}


