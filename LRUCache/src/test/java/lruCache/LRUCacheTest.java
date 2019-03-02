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
		
		@Test
		public void get�֐��Ő������l���Ԃ��Ă��邩�̃e�X�g() {
			lru.testGetMethod();
			assertThat(lru.get("k1"), is("d1"));
		}
		
		@Test
		public void �ۑ�����Ă��Ȃ�key�l�������ɓ����ꂽ��null���Ԃ��Ă��邩�̃e�X�g() {
			lru.testGetMethod();
			assertThat(lru.get("testes"),nullValue());
		}
		
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
