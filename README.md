# WallpaperPlugin
A cordova plugin to set wallpaper (android)

# Installation
Get the Repo
Copy in cordova repository

run commmand:

cordova plugin add setwallpaper

# Usage 

Call setimage function

Currently setImage takes base64 strings only 

# Example:

```cordova.plugins.setwallpaper.setImage(dataUrl, function (res) {
        console.log('response' + res)
      }, function (err) {
        console.log('error' + err)
      })
```
#Note:dataUrl is a base64 string
