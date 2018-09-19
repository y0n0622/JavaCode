.class public Lcom/example/y0n/puppetdex/puppetApplication;
.super Landroid/app/Application;
.source "puppetApplication.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    return-void
.end method

.method private replaceClassLoader(Ldalvik/system/DexClassLoader;)V
    .locals 12
    .param p1, "loader"    # Ldalvik/system/DexClassLoader;

    .prologue
    .line 66
    :try_start_0
    const-string v9, "android.app.ActivityThread"

    invoke-static {v9}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 68
    .local v0, "clazzActivityThread":Ljava/lang/Class;
    const-string v9, "currentActivityThread"

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Class;

    invoke-virtual {v0, v9, v10}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v9

    const/4 v10, 0x0

    const/4 v11, 0x0

    new-array v11, v11, [Ljava/lang/Object;

    .line 69
    invoke-virtual {v9, v10, v11}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 71
    .local v2, "currentActivityThread":Ljava/lang/Object;
    const-string v9, "mPackages"

    invoke-virtual {v0, v9}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v4

    .line 73
    .local v4, "fieldPackages":Ljava/lang/reflect/Field;
    const/4 v9, 0x1

    invoke-virtual {v4, v9}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 75
    invoke-virtual {v4, v2}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/Map;

    .line 77
    .local v6, "mPackages":Ljava/util/Map;
    invoke-virtual {p0}, Lcom/example/y0n/puppetdex/puppetApplication;->getPackageName()Ljava/lang/String;

    move-result-object v7

    .line 79
    .local v7, "packageName":Ljava/lang/String;
    invoke-interface {v6, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/ref/WeakReference;

    .line 83
    .local v8, "ref":Ljava/lang/ref/WeakReference;
    const-string v9, "android.app.LoadedApk"

    invoke-static {v9}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 85
    .local v1, "clazzLoadedApk":Ljava/lang/Class;
    const-string v9, "mClassLoader"

    invoke-virtual {v1, v9}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v5

    .line 87
    .local v5, "fieldmClassLoader":Ljava/lang/reflect/Field;
    const/4 v9, 0x1

    invoke-virtual {v5, v9}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 89
    invoke-virtual {v8}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v9

    invoke-virtual {v5, v9, p1}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 93
    .end local v0    # "clazzActivityThread":Ljava/lang/Class;
    .end local v1    # "clazzLoadedApk":Ljava/lang/Class;
    .end local v2    # "currentActivityThread":Ljava/lang/Object;
    .end local v4    # "fieldPackages":Ljava/lang/reflect/Field;
    .end local v5    # "fieldmClassLoader":Ljava/lang/reflect/Field;
    .end local v6    # "mPackages":Ljava/util/Map;
    .end local v7    # "packageName":Ljava/lang/String;
    .end local v8    # "ref":Ljava/lang/ref/WeakReference;
    :goto_0
    return-void

    .line 90
    :catch_0
    move-exception v3

    .line 91
    .local v3, "e":Ljava/lang/Exception;
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method


# virtual methods
.method protected attachBaseContext(Landroid/content/Context;)V
    .locals 5
    .param p1, "base"    # Landroid/content/Context;

    .prologue
    .line 23
    invoke-super {p0, p1}, Landroid/app/Application;->attachBaseContext(Landroid/content/Context;)V

    .line 24
    const-string v2, "src.dex"

    invoke-virtual {p0, v2}, Lcom/example/y0n/puppetdex/puppetApplication;->copyDex(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 25
    .local v1, "path":Ljava/lang/String;
    new-instance v0, Ldalvik/system/DexClassLoader;

    .line 27
    invoke-virtual {p0}, Lcom/example/y0n/puppetdex/puppetApplication;->getCacheDir()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    .line 28
    invoke-virtual {p0}, Lcom/example/y0n/puppetdex/puppetApplication;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v3

    iget-object v3, v3, Landroid/content/pm/ApplicationInfo;->nativeLibraryDir:Ljava/lang/String;

    .line 29
    invoke-virtual {p0}, Lcom/example/y0n/puppetdex/puppetApplication;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Ldalvik/system/DexClassLoader;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V

    .line 32
    .local v0, "dexClassLoader":Ldalvik/system/DexClassLoader;
    invoke-direct {p0, v0}, Lcom/example/y0n/puppetdex/puppetApplication;->replaceClassLoader(Ldalvik/system/DexClassLoader;)V

    .line 33
    return-void
.end method

.method copyDex(Ljava/lang/String;)Ljava/lang/String;
    .locals 9
    .param p1, "dexName"    # Ljava/lang/String;

    .prologue
    .line 38
    invoke-virtual {p0}, Lcom/example/y0n/puppetdex/puppetApplication;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 40
    .local v0, "as":Landroid/content/res/AssetManager;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/example/y0n/puppetdex/puppetApplication;->getFilesDir()Ljava/io/File;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    sget-object v8, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 44
    .local v6, "path":Ljava/lang/String;
    :try_start_0
    new-instance v5, Ljava/io/FileOutputStream;

    invoke-direct {v5, v6}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    .line 46
    .local v5, "out":Ljava/io/FileOutputStream;
    invoke-virtual {v0, p1}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v3

    .line 48
    .local v3, "is":Ljava/io/InputStream;
    const/16 v7, 0x400

    new-array v1, v7, [B

    .line 49
    .local v1, "buffer":[B
    const/4 v4, 0x0

    .line 50
    .local v4, "len":I
    :goto_0
    invoke-virtual {v3, v1}, Ljava/io/InputStream;->read([B)I

    move-result v4

    const/4 v7, -0x1

    if-eq v4, v7, :cond_0

    .line 51
    const/4 v7, 0x0

    invoke-virtual {v5, v1, v7, v4}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 54
    .end local v1    # "buffer":[B
    .end local v3    # "is":Ljava/io/InputStream;
    .end local v4    # "len":I
    .end local v5    # "out":Ljava/io/FileOutputStream;
    :catch_0
    move-exception v2

    .line 55
    .local v2, "e":Ljava/lang/Exception;
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    .line 56
    const-string v6, ""

    .line 58
    .end local v2    # "e":Ljava/lang/Exception;
    .end local v6    # "path":Ljava/lang/String;
    :goto_1
    return-object v6

    .line 53
    .restart local v1    # "buffer":[B
    .restart local v3    # "is":Ljava/io/InputStream;
    .restart local v4    # "len":I
    .restart local v5    # "out":Ljava/io/FileOutputStream;
    .restart local v6    # "path":Ljava/lang/String;
    :cond_0
    :try_start_1
    invoke-virtual {v5}, Ljava/io/FileOutputStream;->close()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method
