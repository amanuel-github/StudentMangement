import ButtonLink from "../../shared/ButtonLink";
import useCourseListComponentHook from "../../hooks/course/useCourseListComponentHook";

const CourseListComponent = () => {
  const { courses, updateCourse, removeCourse} =
    useCourseListComponentHook();

  return (
    <div className="container">
      <h2 className="text-center py-3">List of Courses</h2>
      <ButtonLink text="Add Course" toAction="/add-course" />
      <table className="table table-striped">
        <thead>
          <tr>
            <th scope="col">Course Description</th>
            <th scope="col">Course  Type</th>
            <th scope="col">Course  Topics</th>
            <th scope="col">Action #1</th>
            <th scope="col">Action #2</th>
          </tr>
        </thead>
        <tbody>
          {courses.map((item) => {
            return (
              <tr key={item.id}>
                <td>{item.description}</td>
                <td>{item.courseType}</td>
                <td>{item.courseTopics}</td>
                <td>
                  <button
                    className="btn btn-outline-info me-2"
                    onClick={() => updateCourse(item.id)}
                  >
                    Update
                  </button>
                </td>
                <td>
                  <button
                    className="btn btn-outline-danger"
                    onClick={() => removeCourse(item.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default CourseListComponent;