# ByteDance Course Homework-3



完成作业之余，做了一些微小的工作：

在练习一的基础上，实现了seekBar的进度条随时间自动滚动，包括在拖动松开后仍然能正常滚动到末尾的行为。

具体实现是通过设置Lottie的监听函数，重写了onAnimationStart和onAnimationRepeat，添加了变量pri记录拖动进度条后的偏移量，并且在动画结束后对pri进行重设，添加了布尔变量lock标记进度条是否在被拖动，通过ValueAnimation实现对进度条自动滚动的控制。



![image-20210714234108582](C:\Users\zjuld\AppData\Roaming\Typora\typora-user-images\image-20210714234108582.png)

