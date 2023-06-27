# FastPrefs
A mini library for practical use of Shared Preferences.

1. Add the Jitpack repository.
```
maven { url 'https://jitpack.io' }
```
2. Add the dependency.
```
implementation 'com.github.yunusemresorkac:FastPrefs:1.0'

```
3. Simple usage.
```
val prefs = FastPrefs(this)
prefs.setString("key","value")
val value = prefs.getString("key","defaultValue")
```
