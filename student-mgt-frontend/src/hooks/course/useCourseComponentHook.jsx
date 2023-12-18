import { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { toast } from "react-toastify";
import {
  getCourseById,
  createCourse,
  updateCourse,
} from "../../services/CourseService";

const useCourseComponentHook = () => {
  const [description, setDescription] = useState("");
  const [courseType, setCourseType] = useState("");
  const [duration, setDuration] = useState("");
  const [courseTopics, setCourseTopics] = useState(""); 
  const [title, setTitle] = useState("");
  const { id } = useParams();
  const navigate = useNavigate();

  const getCourse = async (id) => {
    const response = await getCourseById(id);
    const course = response.data;
    setCourseDescription(course.description);
    setCourseType(course.courseType);
    setCourseDuration(course.duration);
    setCourseTopics(course.courseTopicss);
  };



  useEffect(() => {
    if (id) {
      setTitle("Update Course");
      getCourse(id);
    } else {
      setTitle("Add Course");
    }
  }, [id]);

  const saveOrUpdateCourse = async (e) => {
    e.preventDefault();
    const course = { description, courseType,duration,courseTopics};
    if (description &&  courseType && duration && courseTopics) {
      if (id) {
        await updateCourse(id, course);
        toast.info("Course updated successfully!");
        navigate("/courses");
        return;
      }
      await createCourse(course);
      toast.success("Course added successfully!");
      navigate("/courses");
    } else {
      toast.error("Please fill in all the fields!");
    }
  };

  return {
    description,
    setDescription,
    courseType,
    setCourseType,
    duration,
    setDuration,
    courseTopics,
    setCourseTopics,
    title,
    saveOrUpdateCourse
  };
};

export default useCourseComponentHook;