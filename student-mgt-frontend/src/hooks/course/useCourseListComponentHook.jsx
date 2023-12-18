import { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import {
  deleteCourse,
  courseList,
} from "../../services/CourseService";
import { toast } from "react-toastify";

const useCourseListComponentHook = () => {

  const [courses, setCourses] = useState([]);
  const navigate = useNavigate();

 

  const getCourses = async () => {
    try {
      const response = await courseList();
      setCourses(response.data);
    } catch (err) {
      console.log(err);
    }
  };


  const updateCourse = (id) => {
    navigate(`/edit-course/${id}`);
  };

  const removeCourse = async (id) => {
    await deleteCourse(id);
    toast.error("Course deleted successfully!");
    getCourses();
  };

  useEffect(() => {
    getCourses();
  }, []);

  return {

    courses,
    getCourses,
    updateCourse,
    removeCourse
  };
};

export default useCourseListComponentHook ;