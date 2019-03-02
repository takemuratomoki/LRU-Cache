package lruCache;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import lruCache.LRUCacheClass;

@RunWith(Enclosed.class)
public class LRUCacheTest {
	

	public static class get�֐��֌W{
		
		//�e�X�g�p�錾
		private LRUCacheClass lru;
		
		@Before
		public void �O����() {
			
			lru = new LRUCacheClass();	
		}
		
		//�v�f����5�̎��̂�
		@Test
		public void get�֐��Ő������l���Ԃ��Ă��邩�̃e�X�g() {
			lru.testGetMethod();
			assertThat(lru.get("k1"), is("d1"));
		}
		
		//�v�f����5�̎��̂�
		@Test
		public void �ۑ�����Ă��Ȃ�key�l�������ɓ����ꂽ��null���Ԃ��Ă��邩�̃e�X�g() {
			lru.testGetMethod();
			assertThat(lru.get("testes"),nullValue());
		}
		
		//�v�f����5�̎��̂�
		@Test
		public void get�֐��ň�x�Ăяo�����l���Ō���Ɉړ����Ă��邩�e�X�g() {
			lru.testGetMethod();
			lru.get("k1");
			assertThat(lru.data[3],is("d1"));
		}
	}
	
	public static class put�֐��֌W{
		//�e�X�g�p�錾
		private LRUCacheClass lru;
		
		@Before
		public void �O����() {
			
			lru = new LRUCacheClass();	
		}
		
		@Test
		public void _2�v�f��ǉ���������key�z���null�`�F�b�N() {
			lru.put("hoge1", "hogehoge1");
			lru.put("hoge2", "hogehoge2");
			assertThat(lru.testCNNForKey(),is(2));
		}
		
		@Test
		public void _2�v�f��ǉ���������data�z���null�`�F�b�N() {
			lru.put("hoge1", "hogehoge1");
			lru.put("hoge2", "hogehoge2");
			assertThat(lru.testCNNForData(),is(2));
		}

		@Test
		public void put�֐��Ŕz��̐擪�ɗv�f���ۑ������e�X�g() {
			lru.put("k1", "d1");
			assertThat(lru.data[0],is("d1"));
		}
		
		@Test
		public void _2�x�ڂ�put�֐��Ăяo���œ�Ԗڂɗv�f���ۑ�����邩�̃e�X�g(){
			lru.put("k1", "d1");
			lru.put("k2", "d2");
			assertThat(lru.data[1],is("d2"));
		}
		
		@Test
		public void _2�x�ڂ�put�֐��Ăяo���Ŋ�����key�l���w�肳�ꂽ�Ƃ��㏑�������() {
			lru.put("k1", "d1");
			lru.put("k1", "d2");
			assertThat(lru.get("k1"),is("d2"));
		}
		
		//�v�f����5�̎��̂�
		@Test
		public void put�֐��̎��s�ŗv�f���ő�ƂȂ鎞�擪�f�[�^���폜����邩�̃e�X�g(){
			lru.testGetMethod();
			lru.put("hoge", "hogehoge");
			assertThat(lru.get("k1"),nullValue());
			assertThat(lru.data[0],is("d2"));
		}
		
		//�v�f����5�̎��̂�
		@Test
		public void put�֐��̎��s�ŗv�f���ő�ƂȂ鎞�Ō�̗v�f��null�ɂȂ��Ă��邩�̃e�X�g() {
			lru.testGetMethod();
			lru.put("hoge", "hogehoge");
			assertThat(lru.data[4],nullValue());
		}
		
	}
	
	public static class �z��v�f�`�F�b�N�֌W{
		
		//�e�X�g�p�錾
		private LRUCacheClass lru;
		
		@Before
		public void �O����() {
			
			lru = new LRUCacheClass();	
		}
		
		@Test
		public void �����i�[���Ă��Ȃ�����key�z���null�`�F�b�N() {
			assertThat(lru.testCNNForKey(),is(0));
		}
		
		@Test
		public void �����i�[���Ă��Ȃ�����data�z���null�`�F�b�N() {
			assertThat(lru.testCNNForData(),is(0));
		}
				
		@Test
		public void �z��̗v�f���폜���擪�ɋl�߂�֐��e�X�g() {
			String test[]= {"hoge","hogehoge","hogehogehoge"};
			test = lru.deleteAndSort(1, test);
			assertThat(test[1],is("hogehogehoge"));
		}
	}

	

}
