# android_tech_talk


## Step 1: Setup / Clone
Clone this repo / Setup a New Project with Empty Activity using Android Studio

## Step 2: Common Errors:

```
Failed to find Build Tools revision 27.0.3
Install Build Tools 27.0.3 and sync project
```

Click on the link, to install Build Tools.
(This is a one time setup only. No need to install everytime.)


## Step 3: Wait for a project to load / and install some dependencies [Gradle]

TBA pictures.

Also, it will do update indices for all the files in your project folder. It will take some time. Please wait for it to complete.

Build Completed Status:

TBA pictures.


## Lets build a List view.

## Tips:
- [Convert Icons to Drawable sizes](http://romannurik.github.io/AndroidAssetStudio/nine-patches.html)

### Add a button to Action bar icon

Create a file for menu : `res/menu/add_location.xml`

```
<?xml version="1.0" encoding="utf-8"?>
<menu
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    tools:context=".MainActivity"
    >

    <item
        android:id="@+id/addlocation"
        android:icon="@drawable/button_add32x32"
        android:orderInCategory="300"
        android:title="Add"
        app:showAsAction="ifRoom">

    </item>

</menu>
```

Store the add icon in drawable folder.
Make sure the action bar icon size is about 32 X 32

TPIS: /res/values/styles.xml
```
<!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>

```