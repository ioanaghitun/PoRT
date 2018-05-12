package Data;

import java.util.ArrayList;

public class Post {
	private int id;
	private String title;
	private String description;
	private String incidentDate;
	private String publishDate;
	private float latitude;
	private float longitude;
	private String email;
	private ArrayList<Integer> tags=new ArrayList<Integer>();
	
	public Post(int id, String title, String description, String incidentDate, String publishDate, float latitude,
			float longitude, String email) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.incidentDate = incidentDate;
		this.publishDate = publishDate;
		this.latitude = latitude;
		this.longitude = longitude;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIncidentDate() {
		return incidentDate;
	}

	public void setIncidentDate(String incidentDate) {
		this.incidentDate = incidentDate;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Integer> getTags() {
		return tags;
	}

	public void setTags(ArrayList<Integer> tags) {
		this.tags = tags;
	}
	
	public void addTag(Integer tag) {
		tags.add(tag);
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", description=" + description + ", incidentDate=" + incidentDate
				+ ", publishDate=" + publishDate + ", latitude=" + latitude + ", longitude=" + longitude + ", email="
				+ email + ", tags=" + tags + "]";
	}
	
	

}
