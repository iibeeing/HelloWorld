package com.synchronize;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bank {
	private final int[] accounts;
	private Lock bankLock;
	private Condition sufficientFunds;

	private Logger logger = LoggerFactory.getLogger(Bank.class);
	/**
	 * Constructs the bank.
	 * @param n the number of accounts 100
	 * @param initialBalance 1000
	 * the initial balance for each account
	 */
	public Bank(int n, int initialBalance) {
		accounts = new int[n];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = initialBalance;
		}
		bankLock = new ReentrantLock();
		sufficientFunds = bankLock.newCondition();
	}

	/**
	 * Transfers money from one account to another.
	 * @param from  the account to transfer from
	 * @param to the account to transfer to
	 * @param amount the amount to transfer
	 */
	public synchronized void transfer(int from, int to, int amount) throws InterruptedException {
		//bankLock.lock();
		try {
			while (accounts[from] < amount) {
//				sufficientFunds.await();
				//logger.info(accounts[from] + "小于 " + amount + " 操作等待");
				wait();
			}
			System.out.print(Thread.currentThread());
			accounts[from] -= amount;
			//System.out.println(" from :" + amount + " to :" + to + " " + getTotalBalance());
			//System.out.printf(" %10.2f from %d to %d", amount, from, to);
			System.out.printf(" %d from %d to %d %d %d", amount, from, to,accounts[from],accounts[to]);
			accounts[to] += amount;
			//System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
			System.out.println(" Total Balance:"+ getTotalBalance());
			if(getTotalBalance() != 100000){
				logger.error("getTotalBalance()余额是: " + getTotalBalance());
			}
			//sufficientFunds.signalAll();
			notifyAll();
		} finally {
			//bankLock.unlock();
		}
	}

	/**
	 * Gets the sum of all account balances.
	 * @return the total balance
	 */
	public int getTotalBalance() {
		bankLock.lock();
		try {
			int sum = 0;
			for (int a : accounts)
			{
				sum += a;
			}
			return sum;
		} finally {
			bankLock.unlock();
		}
	}

	/**
	 * Gets the number of accounts in the bank.
	 * @return the number of accounts
	 */
	public int size() {
		return accounts.length;
	}
}
