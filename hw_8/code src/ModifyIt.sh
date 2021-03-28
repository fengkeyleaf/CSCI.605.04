#！/bin/sh
find ./1235.ser -type f | xargs perl -i -pe s%abcdef%abcdee%g # change the password "abcdef" to "abcdee"