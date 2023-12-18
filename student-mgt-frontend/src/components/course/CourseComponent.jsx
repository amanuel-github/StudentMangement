import ButtonLink from "../../shared/ButtonLink";
import useCourseComponentHook  from "../../hooks/course/useCourseComponentHook";

const CourseComponent = () => {
  const {
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
  } = useCourseComponentHook();

  return (
    <div className="container mt-5">
      <ButtonLink text="Go Back" toAction="/courses" />
      <div className="row">
        <div className="card col-md-6 offset-md-3 offset-md-3">
          <h2 className="text-center">{title}</h2>
          <div className="card-body">
            <form>
              <div className="form-group mb-2">
                <label className="form-label">Course Description: </label>
                <input
                  type="text"
                  name="description"
                  placeholder="Course Description:"
                  className="form-control"
                  value={description}
                  onChange={(e) => setDescription(e.target.value)}
                />
              </div>
              <div className="form-group mb-2">
                <label className="form-label">Course Type: </label>
                <input
                  type="text"
                  name="courseType"
                  placeholder="Course Type:"
                  className="form-control"
                  value={courseType}
                  onChange={(e) => setCourseType(e.target.value)}
                />
              </div>
              <div className="form-group mb-2">
                <label className="form-label">Course Duration: </label>
                <input
                  type="text"
                  name="duration"
                  placeholder="Course Duration:"
                  className="form-control"
                  value={duration}
                  onChange={(e) => setDuration(e.target.value)}
                />
              </div>
              <div className="form-group mb-2">
                <label className="form-label">Course Topics: </label>
                <input
                  type="text"
                  name="courseTopics"
                  placeholder="Course Topics:"
                  className="form-control"
                  value={courseTopics}
                  onChange={(e) => setCourseTopics(e.target.value)}
                />
              </div>
              <button
                className="btn btn-outline-success"
                onClick={saveOrUpdateCourse}
              >
                Submit
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CourseComponent;
