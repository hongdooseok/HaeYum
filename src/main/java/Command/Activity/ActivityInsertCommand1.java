package Command.Activity;

import org.springframework.web.multipart.MultipartFile;

public class ActivityInsertCommand1 {
	String activityName;
	String actiStartDate;
	String actiEndDate;
	String recruitPeople;
	String activityText;
	String limitAge;
	MultipartFile[] actiImage;
	String sortOfActivity;
	String whichProduct;
	String activityCity;
	
	
	
	public String getActiStartDate() {
		return actiStartDate;
	}
	public void setActiStartDate(String actiStartDate) {
		this.actiStartDate = actiStartDate;
	}
	public String getActiEndDate() {
		return actiEndDate;
	}
	public void setActiEndDate(String actiEndDate) {
		this.actiEndDate = actiEndDate;
	}
	public String getActivityCity() {
		return activityCity;
	}
	public void setActivityCity(String activityCity) {
		this.activityCity = activityCity;
	}
	public String getWhichProduct() {
		return whichProduct;
	}
	public void setWhichProduct(String whichProduct) {
		this.whichProduct = whichProduct;
	}
	public String getSortOfActivity() {
		return sortOfActivity;
	}
	public void setSortOfActivity(String sortOfActivity) {
		this.sortOfActivity = sortOfActivity;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getRecruitPeople() {
		return recruitPeople;
	}
	public void setRecruitPeople(String recruitPeople) {
		this.recruitPeople = recruitPeople;
	}
	public String getActivityText() {
		return activityText;
	}
	public void setActivityText(String activityText) {
		this.activityText = activityText;
	}
	public String getLimitAge() {
		return limitAge;
	}
	public void setLimitAge(String limitAge) {
		this.limitAge = limitAge;
	}
	public MultipartFile[] getActiImage() {
		return actiImage;
	}
	public void setActiImage(MultipartFile[] actiImage) {
		this.actiImage = actiImage;
	}
	
	
	
	
	
}
