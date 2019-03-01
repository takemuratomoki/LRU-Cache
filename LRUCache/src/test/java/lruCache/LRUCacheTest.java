package lruCache;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class LRUCacheTest {
	
	//�e�X�g�p�錾
	LRUCacheClass lru = new LRUCacheClass();
	
	@Test
	public void ������1��Ԃ�get�֐��e�X�g() {
		assertThat(lru.get("hoge1"),is("1"));
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
}
