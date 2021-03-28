The key idea here is to store the password's hash code, 
which is relatively unique but not guarantee to be identical for all circumstances, into the file when it being serialized.
And after someone modifies the password either through a java file or a shell script, it will not print the password
when the hashcode of the present password is not equal to the previously stored one.