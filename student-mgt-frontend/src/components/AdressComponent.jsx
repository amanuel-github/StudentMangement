import ButtonLink from "./ButtonLink";
import useAdressComponentHook from "../hooks/useAdressComponentHook";

const AdressComponent = () => {
    const {
      city,
      setCity,
      state,
      setState,
      title,
      saveOrUpdateAdress,
    } = useAdressComponentHook();
  
    return (
      <div className="container mt-5">
        <ButtonLink text="Go Back" toAction="/adresses" />
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            <h2 className="text-center">{title}</h2>
            <div className="card-body">
              <form>
                <div className="form-group mb-2">
                  <label className="form-label">City: </label>
                  <input
                    type="text"
                    name="city"
                    placeholder="City"
                    className="form-control"
                    value={city}
                    onChange={(e) => setCity(e.target.value)}
                  />
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">State: </label>
                  <input
                    type="text"
                    name="state"
                    placeholder="Enter State"
                    className="form-control"
                    value={state}
                    onChange={(e) => setState(e.target.value)}
                  />
                </div>
                <button
                  className="btn btn-outline-success"
                  onClick={saveOrUpdateAdress}
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
  
  export default AdressComponent;
  