### 递归
    递归：方法定义中调用方法本身的现象
    
    方法的嵌套调用，这不是递归。
    Math.max(Math.max(a,b),c);
    
    public void show(int n) {
            if(n <= 0) {
                System.exit(0);
            }
            System.out.println(n);
            show(--n);
    }
    
    注意事项：
            A:递归一定要有出口，否则就是死递归
            B:递归的次数不能太多，否则就内存溢出
            C:构造方法不能递归使用
    
    举例：
            A:从前有座山，山里有座庙，庙里有个老和尚和小和尚，老和尚在给小和尚讲故事，故事是：
                从前有座山，山里有座庙，庙里有个老和尚和小和尚，老和尚在给小和尚讲故事，故事是：
                    从前有座山，山里有座庙，庙里有个老和尚和小和尚，老和尚在给小和尚讲故事，故事是：
                        从前有座山，山里有座庙，庙里有个老和尚和小和尚，老和尚在给小和尚讲故事，故事是：
                            ...
                        庙挂了,或者山崩了
            B:学编程  -- 高薪就业 -- 挣钱 -- 娶媳妇 -- 生娃娃 -- 放羊 -- 挣学费
                 学编程  -- 高薪就业 -- 挣钱 -- 娶媳妇 -- 生娃娃 -- 放羊 -- 挣学费
                    学编程  -- 高薪就业 -- 挣钱 -- 娶媳妇 -- 生娃娃 -- 放羊 -- 挣学费
                        学编程  -- 高薪就业 -- 挣钱 -- 娶媳妇 -- 生娃娃 -- 放羊 -- 挣学费
                            ...
                        娶不到媳妇或者生不了娃娃
    递归实现
            a:做递归要写一个方法
            b:出口条件
            c:规律
            
### IO流
    IO流的分类
        流向：
        分类的参照物是java程序：
            输入流     读取数据（从硬盘读取数据）
            输出流     写出数据（使用程序写入硬盘）
        数据类型：
            字节流
                字节输入流       读取数据（从硬盘读取数据）   InputStream    
                字节输出流       写出数据（使用程序写入硬盘   OutputStream
            字符流
                字符输入流       读取数据（从硬盘读取数据）   Reader  
                字符输出流       写出数据（使用程序写入硬盘   Writer
            
        一般在讨论IO流的时候，一般是按照数据类型来进行区分的
    分析：
    		A:这个操作最好是采用字符流来做，但是呢，字符流是在字节流之后才出现的，所以，今天我先讲解字节流如何操作。
    		B:由于我是要往文件中写一句话，所以我们要采用字节输出流。
    
    通过上面的分析后我们知道要使用：OutputStream
    但是通过查看API，我们发现该流对象是一个抽象类，不能实例化。
    所以，我们要找一个具体的子类。
    而我们要找的子类是什么名字的呢?这个时候，很简单，我们回想一下，我们是不是要往文件中写东西。
    文件是哪个单词：File
    然后用的是字节输出流，联起来就是：FileOutputStream
    注意：每种基类的子类都是以父类名作为后缀名。
    		XxxOutputStream
    		XxxInputStream
    		XxxReader
    		XxxWriter
    查看FileOutputStream的构造方法：
    		FileOutputStream(File file) 
    		FileOutputStream(String name)
    
    字节输出流操作步骤：
    		A:创建字节输出流对象
    		B:写数据
    		C:释放资源
    
    如何实现数据的换行?
    		为什么现在没有换行呢?因为你值写了字节数据，并没有写入换行符号。
    		如何实现呢?写入换行符号即可呗。
    		刚才我们看到了有写文本文件打开是可以的，通过windows自带的那个不行，为什么呢?
    		因为不同的系统针对不同的换行符号识别是不一样的?
    		windows:\r\n
    		linux:\n
    		Mac:\r
    		而一些常见的个高级记事本，是可以识别任意换行符号的。
    
    如何实现数据的追加写入?
    		用构造方法带第二个参数是true的情况即可
    
    
    通过定义数组的方式确实比以前一次读取一个字节的方式快很多，所以，看来有一个缓冲区还是非常好的。
    既然是这样的话，那么，java开始在设计的时候，它也考虑到了这个问题，就专门提供了带缓冲区的字节类。
    这种类被称为：缓冲区类(高效类)
    写数据：BufferedOutputStream
    读数据：BufferedInputStream
    
    构造方法可以指定缓冲区的大小，但是我们一般用不上，因为默认缓冲区大小就足够了。
    
    为什么不传递一个具体的文件或者文件路径，而是传递一个OutputStream对象呢?
    原因很简单，字节缓冲区流仅仅提供缓冲区，为高效而设计的。但是呢，真正的读写操作还得靠基本的流对象实现。
    