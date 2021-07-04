/**
 * 
 */
package com.api.ratelimiter.response;

import java.util.List;

/**
 * @author vikas
 *
 */
public class ResponseWrapperClass<T> {
	
	private String errorCode;
	
	private String errorDescription;
	
	private List<T> collectionData;
	
	private T data;

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}

	/**
	 * @return the collectionData
	 */
	public List<T> getCollectionData() {
		return collectionData;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @param errorDescription the errorDescription to set
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	/**
	 * @param collectionData the collectionData to set
	 */
	public void setCollectionData(List<T> collectionData) {
		this.collectionData = collectionData;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
}
