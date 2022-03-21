package com.example.web.models;

public class Course {
    private int id;
    private String courseCode;
    private String name;
    private int instructorId;
    private int semester;
    private int assessmentId;

    public Course(String courseCode, String name, int instructorId, int semester, int assessmentId) {
        this.courseCode = courseCode;
        this.name = name;
        this.instructorId = instructorId;
        this.semester = semester;
        this.assessmentId = assessmentId;
    }

    public Course(int id, String courseCode, String name, int instructorId, int semester, int assessmentId) {
        this.id = id;
        this.courseCode = courseCode;
        this.name = name;
        this.instructorId = instructorId;
        this.semester = semester;
        this.assessmentId = assessmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    @Override
    public String toString() {
        return "Course " +
                "id=" + id +
                ", courseCode='" + courseCode + '\'' +
                ", name='" + name + '\'' +
                ", instructorId=" + instructorId +
                ", semester=" + semester +
                ", assessmentId=" + assessmentId;
    }
}
