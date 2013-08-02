/**
 * question2：
 *  	write a program to find whether a machine is big endian or little endian 
 *  	写一个程序，判断一个机器是大端序还是小端序
 *  	这道题目用java是无法实现的，因为在java中，字节顺序是BIG_ENDIAN的，因为所有的java程序都是运行在jvm上的，而jvm为了
 *  	保持一致性，规定了jvm上的数据的字节顺序是BIG_ENDIAN
 */
#define BIG_ENDIAN 0
#define LITTLE_ENDIAN 1
 void main(){
	short int word=0x0001;
	char* byte = (char *)&word;
	return (byte[0]?LITTLE_ENDIAN:BIG_ENDIAN;
 }