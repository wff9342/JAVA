package test;

import java.util.Arrays;
import java.util.Random;

public class Twonumbers {
	public static int number1(int x) {
		int s=(int)(Math.random()*33+1);
		return s;
	}
	public static int number2(int y) {
		int s=(int)(Math.random()*16+1);
		return s;
	}
	public static void main(String[] args) {
//1> ���һ����ά����ĸ��ƹ��ܡ�
//		int[][]numss= {{1,2,3},{1,2},{1}};
//		// ��Java�����У� clone������������ã����ԻḴ�ƶ���
//		//��ν�ĸ��ƶ�������Ҫ����һ����Դ����ͬ����С�Ŀռ䣬������ռ��д���һ���µĶ���	
//		//int[][]nums=numss.clone();
//		int[][]nums=new int[3][];
//		for(int i=0;i<numss.length;i++) {
//			for(int j=0;j<numss[i].length;j++) {
//				nums[i][j]=numss[i][j];
//			}
//			System.out.println(Arrays.toString(nums[i]));
//		}
//		
		
		
//2>������������3��3����ĺͣ���ÿ��Ԫ��ֵ������һ��3��3 �������С�
//
//	     11     15     18                     45     -6     9   
//	     22     16     19         +           51    52     53     =   ��
//	     32     37     38                     -13    25    -60
//		int[][]a= {{11,15,18},{22,16,19},{32,37,38}};
//		int[][]b= {{45,-6,9},{51,52,53},{-13,25,-60}};
//		int[][]c= new int[3][3];
//		for(int i=0;i<a.length;i++) {
//			for(int j=0;j<a[i].length;j++) {
//				c[i][j]=a[i][j]+b[i][j];
//			}
//			System.out.println(Arrays.toString(c[i]));
//		}
		
		
//3> ������4 �� 4�ľ���������л�����
//		int[][]a= {{11,12,13,14},{21,22,23,24},{31,32,33,34},{41,42,43,44}};
//		int[][]b=new int[4][4];
//		for(int i=0;i<a.length;i++) {
//			for(int j=0;j<a[i].length;j++) {
//				b[i][j]=a[j][i];
//			}
//			System.out.println(Arrays.toString(b[i]));
//		}

		
		
//4>˫ɫ��������ɳ���ʵ�֡�
//�û�����ͨ�������������������5�����µ�˫ɫ����롣˫ɫ��
//����7��������ɣ�ǰ��λ���ֳ�֮Ϊ��ɫ���룬���뷶Χ
//(1~33)�������ظ�����1λΪ��ɫ���룬���뷶Χ(1~16)������
// ��ɫ�����ظ���
		Random random=new Random();		
		int[][] a=new int[5][7];
		for(int k=0;k<a.length;k++) {
			a[k][6]=number2(a[k][6]);
			for(int i=0;i<a[k].length;i++) {
				boolean flag=false;
				for(int j=0;j<i;j++) {
					if(a[k][i]==a[k][j]) {
						flag=true;
						break;
					}
				}
				if(!flag) {
					a[k][i]=number1(a[k][i]);
				}	
			}
			System.out.println(Arrays.toString(a[k]));
		}
		
		
		
		
//5>���� ʹ�ö�ά���鶨����ʵ�ֶԲ�ͬ��ʮ���ط����¶Ƚ��м�⣬
//�������һ ����ÿ���ط���ƽ���¶ȡ�
//Ҫ�� ����û��ʵ�ʵ��¶����ݣ�
//�����ó����Զ�������ֵ����Ϊ��⵽���¶� ֵ��
//Ҫ���¶ȵķ�Χ��[��10��~~35��)֮�������ƣ�
//�������ÿ���ط�����ƽ���¶�ֵ��
//		Random random=new Random();
//		int[][]a=new int[10][12];		
//		for(int i=0;i<a.length;i++) {			
//			int sum=0;
//			int avg=0;
//			for(int j=0;j<a[i].length;j++) {
//				int s=(int)(Math.random()*46-10);
//				a[i][j]=s;
//				sum+=a[i][j];
//				//System.out.println(s);
//			}
//			avg=sum/a[i].length;
//			
//			System.out.println("��"+(i+1)+"�����е�ƽ��������"+avg);
//		}
		
		
		
//6>  �������飬���ָ���е���������� ��
//��������Σ����������ʵ������ǣ���������б�߶���������1��ɵģ�������������ǵ��������ϵ�������֮�͡�
//1
//1   1
//1   2    1
//1   3    3    1
//1   4    6    4    1
//1   5    10   10   5    1
//1   6    15   20   15    6    1
//1   7    21   35   35    21   7    1
//		int[][]a=new int[8][8];
////		a[0][0]=1;
////		a[1][0]=1;
////		a[1][1]=1;
//		
//		for(int i=0;i<a.length;i++) {			
//			for(int j=0;j<=i;j++) {
//				if(j==0||i==j) {
//					a[i][j]=1;
//					System.out.print(a[i][j]+" ");
//					continue;
//				}
//				a[i][j]=a[i-1][j-1]+a[i-1][j];
//				System.out.print(a[i][j]+" ");
//			}
//			System.out.println();
//		}
		
	}
}
