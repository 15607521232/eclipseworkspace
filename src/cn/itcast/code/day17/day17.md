### Set接口概述
    一个不包含重复元素的 collection
    
    Collection
        List 有序(存储顺序和取出顺序一致)，可重复
        Set  无序（存储顺序和取出顺序不一致），唯一,虽然Set集合的元素无需，但是，作为集合来说，它肯定有自己的存储顺序，而你的顺序和他的存储顺序一致，代表不了它就是有序的
        
    HashSet：它不保证set的迭代顺序，特别是他不保证该顺序恒久不变
     HashSet:存储字符串并遍历
      问题：为什么存储字符串的时候，字符串内容相同的只存储了一个呢?
      通过查看add方法的源码，我们知道这个方法底层依赖 两个方法：hashCode()和equals()。
      步骤：
      		首先比较哈希值
      		如果相同，继续走，比较地址值或者走equals()
      		如果不同,就直接添加到集合中	
      按照方法的步骤来说：	
      		先看hashCode()值是否相同
      			相同:继续走equals()方法
      				返回true：	说明元素重复，就不添加
      				返回false：说明元素不重复，就添加到集合
      			不同：就直接把元素添加到集合
      如果类没有重写这两个方法，默认使用的Object()。一般来说不同相同。
      而String类重写了hashCode()和equals()方法，所以，它就可以把内容相同的字符串去掉。
      注意了：
       		你使用的是HashSet集合，这个集合的底层是哈希表结构。
       		而哈希表结构底层依赖:hashCode()和equals()方法。
       		如果你认为对象的成员变量值相同即为同一个对象的话，你就应该重写这两个方法。
       		如何重写呢?不同担心，自动生成即可。
      LinkedHashSet:底层数据结构由哈希表和链表组成。
          哈希表保证元素的唯一性。
          链表保证元素有素。(存储和取出是一致)
    