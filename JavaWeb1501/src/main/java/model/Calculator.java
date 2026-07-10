package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Calculatorクラスは、<br>
・商品のリストから呼び出した商品価格に消費税(*1.1)を計算するメソッド<br>
・税込み価格にする計算を商品ごとに計算して合算し、買い物金額の合計を出すという計算メソッド
<br>の2つを入れている

 */



public class Calculator {
	
	final double TAX = 1.1;

	public static void main(String[] args) {
		List<Product> productList =new ArrayList<Product>();
		
	//商品追加
		productList.add(new Product("A110", "無線マウス", 2000));
		productList.add(new Product("A120", "薄型キーボード", 3600));
	
	//Calculatorメソッドを呼び出して合計金額(消費税込み)を計算する
		Calculator calculator = new Calculator();
		int total = calculator.calculate(productList);
	
	//合計金額を出力する
	System.out.println(total);
	}
	
	/**
	 * 商品の価格に税率 (TAX) を掛けて、結果を int 型として返す。
	 * @param product 商品価格
	 * 
	 */
	public int plusTax(int product) { return (int) (product * TAX); 
	
}
/**
 * 商品のリストを呼び出して商品*消費税1.1の合算処理を1つずつ行い、
 * 毎回合計金額を返す→最終的に税込で合算したものが出力される
 * 
 * @param listProd 商品のリスト
 * @return totalPurchase:加算したもの(product+TAX)
 */

public int calculate(List<Product> listProd) { 
	
	int totalPurchase =0;
	for (int i =0; i< listProd.size(); i++ ){ 
		Product product = listProd.get(i);
		totalPurchase = totalPurchase+plusTax(product.getPrice()); }
	return totalPurchase;
	
}

/* public int getTotalPrice(){
 * int total =0;
 * for(product prod : listProd){
 * 		total += prod.getPrice();
 * }
 * return total;
 * }
 */

	}

