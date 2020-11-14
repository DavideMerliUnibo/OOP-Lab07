package it.unibo.oop.lab.nesting2;

import java.util.Iterator;
import java.util.List;


public class OneListAcceptable<T> implements Acceptable<T>{

	private List<T> list;
	
	public OneListAcceptable(List<T> list) {
		this.list = list;
	}
	
	public Acceptor<T> acceptor() {
		Iterator<T> iter = list.iterator();
		return new Acceptor<>() {

			public void accept(T newElement) throws ElementNotAcceptedException {
				try {
					if(newElement.equals(iter.next())) {
						return;
					}
				} catch(Exception e) {
					System.out.println("End of list!");
				}
				throw new ElementNotAcceptedException(newElement);
			}

			public void end() throws EndNotAcceptedException {
				try {
					if(!iter.hasNext()) {
						return;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				throw new EndNotAcceptedException();
			}
		};
	}
}
