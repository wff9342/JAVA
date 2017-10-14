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
//1> 完成一个二维数组的复制功能。
//		int[][]numss= {{1,2,3},{1,2},{1}};
//		// 在Java语言中， clone方法被对象调用，所以会复制对象。
//		//所谓的复制对象，首先要分配一个和源对象同样大小的空间，在这个空间中创建一个新的对象。	
//		//int[][]nums=numss.clone();
//		int[][]nums=new int[3][];
//		for(int i=0;i<numss.length;i++) {
//			for(int j=0;j<numss[i].length;j++) {
//				nums[i][j]=numss[i][j];
//			}
//			System.out.println(Arrays.toString(nums[i]));
//		}
//		
		
		
//2>计算下面两个3×3矩阵的和，将每个元素值放置在一个3×3 的数组中。
//
//	     11     15     18                     45     -6     9   
//	     22     16     19         +           51    52     53     =   ？
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
		
		
//3> 将下面4 × 4的矩阵进行行列互换。
//		int[][]a= {{11,12,13,14},{21,22,23,24},{31,32,33,34},{41,42,43,44}};
//		int[][]b=new int[4][4];
//		for(int i=0;i<a.length;i++) {
//			for(int j=0;j<a[i].length;j++) {
//				b[i][j]=a[j][i];
//			}
//			System.out.println(Arrays.toString(b[i]));
//		}

		
		
//4>双色球号码生成程序实现。
//用户可以通过输入组数，随机生成5组以下的双色球号码。双色球
//共由7个数字组成，前六位数字称之为红色号码，号码范围
//(1~33)，不可重复，后1位为兰色号码，号码范围(1~16)，可与
// 兰色号码重复。
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
		
		
		
		
//5>需求： 使用二维数组定义来实现对不同的十个地方的温度进行监测，
//而计算出一 年中每个地方的平均温度。
//要求： 由于没有实际的温度数据，
//可以让程序自动产生数值来作为监测到的温度 值，
//要求温度的范围在[－10度~~35度)之间进行设计，
//最后计算出每个地方的年平均温度值。
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
//			System.out.println("第"+(i+1)+"各城市的平均气温是"+avg);
//		}
		
		
		
//6>  利用数组，输出指定行的杨辉三角形 。
//杨辉三角形：杨辉三角最本质的特征是，它的两条斜边都是由数字1组成的，而其余的数则是等于它肩上的两个数之和。
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
