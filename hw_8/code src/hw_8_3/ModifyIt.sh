#！/bin/sh
find ./1235.ser -type f | xargs perl -i -pe s%abcdef%abcdee%g # change the password "abcdef" to "abcdee"

# 老师的方法，java用copy program，读了再写进去，思路和下面的命令行相一致
# script:
# dd if=1234.ser of=1 bs=1 count=79    2 > /dev/null  # dd if=1234.ser(读取目标文件) of=1(output file) bs=1(buffer size) count=79(读多少个字符)
# /bin/echo -n xbcdef > 2  # 将"xbcdef"写进 2
# dd if=1234.ser of=3 bs=1 skip=85     2 > /dev/null  # dd if=1234.ser(读取目标文件) of=3(output file) bs=1(buffer size) skip=85(跳过多少个字符)
# cat 1 2 3 > modified.ser  # 将文件1、2和3写进modified.ser