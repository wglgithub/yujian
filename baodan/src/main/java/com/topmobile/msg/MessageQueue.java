package com.topmobile.msg;

import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
/**
 * 缓存往mq队列的待加入队列的群消息
 *
 * @author wgl
 * @date 2016年9月6日 下午6:52:21
 */
public class MessageQueue {
	/**
	 * 待发mq送消息队列
	 */
	private static final BlockingQueue<Message> msgStore = new LinkedBlockingDeque<Message>();
	
	/**
	 * 添加一个待发送的消息
	 * @param msg
	 */
	public static void addMsg(Message msg){
		msgStore.add(msg);
	}
	
	public static void addBatchMsg(Collection<Message> msgs){
		msgStore.addAll(msgs);
	}
	/**
     * Retrieves and removes the head of this queue, waiting if necessary
     * until an element becomes available.
     *
     * @return the head of this queue
     * @throws InterruptedException if interrupted while waiting
     */
	public static Message take() throws InterruptedException{
		return msgStore.take();
	}
	/**
     * Inserts the specified element into this queue if it is possible to do
     * so immediately without violating capacity restrictions, returning
     * <tt>true</tt> upon success and throwing an
     * <tt>IllegalStateException</tt> if no space is currently available.
     * When using a capacity-restricted queue, it is generally preferable to
     * use {@link #offer(Object) offer}.
     *
     * @param e the element to add
     * @return <tt>true</tt> (as specified by {@link Collection#add})
     * @throws IllegalStateException if the element cannot be added at this
     *         time due to capacity restrictions
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the specified element is null
     * @throws IllegalArgumentException if some property of the specified
     *         element prevents it from being added to this queue
     */
	public static boolean put(Message msg){
		return msgStore.add(msg);
	}
}
