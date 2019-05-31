package com.landvibe.trustfarm

import java.io.IOException
import javax.imageio.ImageIO
import sun.swing.plaf.synth.SynthIcon.getIconHeight
import java.awt.image.BufferedImage
import sun.swing.plaf.synth.SynthIcon.getIconWidth
import java.awt.Color
import java.awt.Font
import java.awt.Image
import java.io.File
import java.util.*
import javax.swing.ImageIcon


class PhotoUtils {
    companion object {
        fun watermark(filePath: String, info: String, certification: String) {
            val origFile = File(filePath)
            val originalIcon = ImageIcon(origFile.path)
            val icon = ImageIcon(originalIcon.image.getScaledInstance(400, 300, Image.SCALE_SMOOTH))
            val bufferedImage = BufferedImage(icon.iconWidth, icon.iconHeight, BufferedImage.TYPE_INT_RGB)
            val graphics = bufferedImage.graphics
            graphics.drawImage(icon.image, 0, 0, null)
            graphics.font = Font("Arial", Font.PLAIN, 15)
            graphics.color = Color.yellow
            graphics.drawString(Date().toString(), 5, 20)
            var line = 1
            for (string in info.split("/")) {
                graphics.drawString(string, 5, 20 * (line + 1))
                line += 1
            }
            graphics.color = Color.blue
            graphics.font = Font("Arial", Font.PLAIN, 20)
            graphics.drawString("Certification : $certification", 10, icon.iconHeight - 10)
            graphics.dispose()
            val newFile = File(filePath)
            try {
                ImageIO.write(bufferedImage, "png", newFile)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}