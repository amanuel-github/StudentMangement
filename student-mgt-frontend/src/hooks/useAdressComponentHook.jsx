import { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { toast } from "react-toastify";
import {
  getAdressById,
  createAdress,
  updateAdress,
} from "../services/AdressService";

const useAdressComponentHook = () => {
    const [city, setCity] = useState("");
    const [state, setState] = useState("");
    const [title, setTitle] = useState("");
    const { id } = useParams();
    const navigate = useNavigate();
  
    const getAdress = async (id) => {
      const response = await getAdressById(id);
      const adress = response.data;
      setCity(adress.city);
      setState(adress.state);
    };
  
    useEffect(() => {
      if (id) {
        setTitle("Update Adress");
        getDepartment(id);
      } else {
        setTitle("Add Adress");
      }
    }, [id]);
  
    const saveOrUpdateAdress = async (e) => {
      e.preventDefault();
      const adress = { city, state};
      if (city && state) {
        if (id) {
          await updateAdress(id, adress);
          toast.info("Department updated successfully!");
          navigate("/departments");
          return;
        }
        await createAdress(adress);
        toast.success("Department added successfully!");
        navigate("/departments");
      } else {
        toast.error("Please fill in all the fields!");
      }
    };
  
    return {
      city,
      setCity,
      state,
      setState,
      title,
      saveOrUpdateAdress,
    };
  };
  
  export default useAdressComponentHook;