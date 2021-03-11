import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class StudentApplication {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "id", "points", "major", "faculty", "highschoolDiploma", "testimonyOfFirstYear",
			"testimonyOfSecondYear", "testimonyOfThirdYear", "testimonyOfFourthYear", "birthCertificate", "content",
			"dateOfApplication", "student" })

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("points")
	private Integer points;
	@JsonProperty("major")
	private String major;
	@JsonProperty("faculty")
	private String faculty;
	@JsonProperty("highschoolDiploma")
	private String highschoolDiploma;
	@JsonProperty("testimonyOfFirstYear")
	private String testimonyOfFirstYear;
	@JsonProperty("testimonyOfSecondYear")
	private String testimonyOfSecondYear;
	@JsonProperty("testimonyOfThirdYear")
	private String testimonyOfThirdYear;
	@JsonProperty("testimonyOfFourthYear")
	private String testimonyOfFourthYear;
	@JsonProperty("birthCertificate")
	private String birthCertificate;
	@JsonProperty("content")
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@JsonProperty("dateOfApplication")
	private String dateOfApplication;
	@JsonProperty("student")
	private Student student;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("points")
	public Integer getPoints() {
		return points;
	}

	@JsonProperty("points")
	public void setPoints(Integer points) {
		this.points = points;
	}

	@JsonProperty("major")
	public String getMajor() {
		return major;
	}

	@JsonProperty("major")
	public void setMajor(String major) {
		this.major = major;
	}

	@JsonProperty("faculty")
	public String getFaculty() {
		return faculty;
	}

	@JsonProperty("faculty")
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	@JsonProperty("highschoolDiploma")
	public String getHighschoolDiploma() {
		return highschoolDiploma;
	}

	@JsonProperty("highschoolDiploma")
	public void setHighschoolDiploma(String highschoolDiploma) {
		this.highschoolDiploma = highschoolDiploma;
	}

	@JsonProperty("testimonyOfFirstYear")
	public String getTestimonyOfFirstYear() {
		return testimonyOfFirstYear;
	}

	@JsonProperty("testimonyOfFirstYear")
	public void setTestimonyOfFirstYear(String testimonyOfFirstYear) {
		this.testimonyOfFirstYear = testimonyOfFirstYear;
	}

	@JsonProperty("testimonyOfSecondYear")
	public String getTestimonyOfSecondYear() {
		return testimonyOfSecondYear;
	}

	@JsonProperty("testimonyOfSecondYear")
	public void setTestimonyOfSecondYear(String testimonyOfSecondYear) {
		this.testimonyOfSecondYear = testimonyOfSecondYear;
	}

	@JsonProperty("testimonyOfThirdYear")
	public String getTestimonyOfThirdYear() {
		return testimonyOfThirdYear;
	}

	@JsonProperty("testimonyOfThirdYear")
	public void setTestimonyOfThirdYear(String testimonyOfThirdYear) {
		this.testimonyOfThirdYear = testimonyOfThirdYear;
	}

	@JsonProperty("testimonyOfFourthYear")
	public String getTestimonyOfFourthYear() {
		return testimonyOfFourthYear;
	}

	@JsonProperty("testimonyOfFourthYear")
	public void setTestimonyOfFourthYear(String testimonyOfFourthYear) {
		this.testimonyOfFourthYear = testimonyOfFourthYear;
	}

	@JsonProperty("birthCertificate")
	public String getBirthCertificate() {
		return birthCertificate;
	}

	@JsonProperty("birthCertificate")
	public void setBirthCertificate(String birthCertificate) {
		this.birthCertificate = birthCertificate;
	}

	@JsonProperty("dateOfApplication")
	public String getDateOfApplication() {
		return dateOfApplication;
	}

	@JsonProperty("dateOfApplication")
	public void setDateOfApplication(String dateOfApplication) {
		this.dateOfApplication = dateOfApplication;
	}

	@JsonProperty("student")
	public Student getStudent() {
		return student;
	}

	@JsonProperty("student")
	public void setStudent(Student student) {
		this.student = student;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
