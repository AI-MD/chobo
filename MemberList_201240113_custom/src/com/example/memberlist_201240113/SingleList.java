package com.example.memberlist_201240113;

import java.util.ArrayList;
/*
 * �̱��� Ŭ����
 * ���� ��Ƽ��Ƽ �Ǵ� ���� Ŭ�������� �Բ� �����ϰ� ���� �ڿ����� �̱��� �������� ����� �۾��Ѵ�.
 * �ڹ� ���� �Ҷ��� �����ϰ� ����
 * 
 * Ŭ���� �ȿ� ����Ʈ�� static �ϰ� �����ϰ� ���� �ȵǴ� ������ �ش� Ŭ������ �Ǵ� ��Ƽ��Ƽ�� ����ִ� ���ȸ� ������ ������� ��� �۷ι��ϰ� static �� ��ü�� �������� �����ϰ� �� �� ����
 * 
 */
public  class SingleList {
	
	private static ArrayList<MemberVO> list = new ArrayList<MemberVO>();//list ��ü �ʱ�ȭ �ݵ�� ������� �ƴϸ� ������Ʈ �Լ��� ��
	private static SingleList instance;//Ŭ���� �̸����� ������ ������ ����
	
	
	private SingleList(){//private���� ������ �Լ� ���� �ֳ��ϸ� �ܺο��� �ش� Ŭ������ �ν��Ͻ� ������ ���ϰ� �ϱ�����  �ݵ�� ��Ÿ���߿� �Ѱ��� �ν��Ͻ��� �����ϱ� ����
		
	}
	public static SingleList getInstance(){//��� �ν��Ͻ� �����ϴ� �޼ҵ带 ���� ���� instance�� ���϶��� ���� null �� �ƴҶ� �׳� ����
		if(instance ==null)
			instance=new SingleList();
		return instance;
	}
	/*
	 * �Ʒ��� getter�� add �޼ҵ� ������̴� ����
	 */
	public static ArrayList<MemberVO> getList() {
		return list;
	}



	public static void add(MemberVO mvo){
		list.add(mvo);
	};
	
	
	
	
	
	
	
}
