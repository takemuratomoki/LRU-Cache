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
		public void ������1��Ԃ�get�֐��e�X�g() {
			assertThat(lru.get("hoge1"),is("1"));
		}
	}
	
//	public static class put�֐��֌W{
//		
//	}
	
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
		public void �z��̗v�f���폜���擪�ɋl�߂�֐��e�X�g() {
			String test[]= {"hoge","hogehoge","hogehogehoge"};
			test = lru.deleteAndSort(1, test);
			assertThat(test[1],is("hogehogehoge"));
		}
	}

	

}
