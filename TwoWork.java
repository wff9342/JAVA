package test;

import java.util.Scanner;

public class TwoWork {
	public static void main(String []args) {
//1! + (1!+2!) + ���� +(1!+2!+3!+4!+5!)��ֵ
//		int tmp=1;
//		int sum=0;
//		int res=0;
//		for(int i=1;i<=5;i++) {
//			tmp=tmp*i;
//			sum=sum+tmp;
//			res=res+sum;
//		}
//		System.out.println(res);
		
		
//����λ����ȫ��ˮ�ɻ���
//		for(int i=100;i<1000;i++) {
//			int x=i/100;
//			int y=i/10%10;
//			int z=i%10;
//			if(x*x*x+y*y*y+z*z*z==i) {
//				System.out.println(i);
//			}
//		}
		
//����ʱ���abcdefg�����
//		char[] myList = {'a','b','c','d','e','f','g','h','i','m','l','h'};
//		for(int i=6;i>=0;i--) {
//    		int s=2*i-1;
//    		for(int y=6-i;y>=1;y--) {
//    			System.out.print(" ");
//    		}
//    		for(int x=0;x<s;x++) {
//    			
//    			System.out.print(myList[x]);
//    		}
//    		System.out.println();	
//    	}

		
		
		
//����2�����֣���2�������е����Լ������С��������
//		Scanner scan = new Scanner(System.in);
//		int a=0;
//		int b=0;
//		System.out.print("�������һ��������");		
//		a=scan.nextInt();		
//		System.out.print("������ڶ���������");		
//		b=scan.nextInt();
//		if(a>b) {
//			int tmp=b;
//			b=a;
//			a=tmp;
//		}
//		for(int i=a;i>=1;i--) {
//			if(a%i==0&&b%i==0) {
//				System.out.println("��С��Լ��Ϊ��"+i);
//				break;
//			}
//			
//		}
//		for(int i=1;i<=a;i++) {
//			for(int z=a;z<=b;z++) {
//				if(b*i==a*z) {
//					System.out.println("��С������Ϊ��"+b*i);
//					break;
//				}
//			}
//		}
		
		
		
//��д�������һ���á�*���ű�ʾ������
//		for(int z=1;z<=3;z++) {
//			int p=2*z-1;
//			for(int i=1;i<=4-z;i++) {
//				System.out.print(" ");
//			}
//			for(int x=1;x<=p;x++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		
//		for(int i=4;i>=0;i--) {
//    		int s=2*i-1;
//    		for(int y=4-i;y>=1;y--) {
//    			System.out.print(" ");
//    		}
//    		for(int x=0;x<s;x++) {
//    			System.out.print("*");
//    		}
//    		System.out.println();	
//    	}
		
		
//����10000���ڵ���ȫ��
//˼·����ȫ����ָ��������Լ�����������������ĺ͵��ڸ�������	
		//tmp=0;������ѭ������ı���������Ϊһ��ѭ���Ľ���������		
		for(int i=1;i<=10000;i++) {
			int tmp=0;
			for(int z=1;z<i;z++) {//Լ��	
				if(i%z==0) {
					tmp=tmp+z;					
				}
			}
			if(tmp==i) {
				System.out.println(i);
			}
		}

		
	}	
}
