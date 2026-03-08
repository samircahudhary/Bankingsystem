import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { ShieldCheck, Lock, Mail, Eye, EyeOff, ChevronRight } from "lucide-react"; 
import "./Login.css";

function Login() {
  const navigate = useNavigate();
  const [showPassword, setShowPassword] = useState(false);
  const [isLoading, setIsLoading] = useState(false);
  const [form, setForm] = useState({ email: "", password: "" });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setIsLoading(true); // Start the "Premium" loading feel

    try {
      const response = await axios.post("http://localhost:8081/api/login", form);
      localStorage.setItem("user", JSON.stringify(response.data));
      
      // Artificial delay for a "Security Scanning" effect
      setTimeout(() => {
        navigate("/dashboard");
      }, 1500);
    } catch (err) {
      setIsLoading(false);
      alert("Invalid Credentials. Access Denied.");
    }
  };

  return (
    <div className="login-page">
      {/* Animated Background Elements */}
      <div className="bg-glow-1"></div>
      <div className="bg-glow-2"></div>

      <div className="login-container">
        <header className="bank-header">
          <div className="logo-box">
            <ShieldCheck size={48} className="logo-icon" />
          </div>
          <h1>PREMIUM BANK</h1>
          <p className="subtitle">OF INDIA</p>
          <div className="encryption-badge">
            <span className="pulse-dot"></span> 256-BIT ENCRYPTION ACTIVE
          </div>
        </header>

        <div className="glass-card">
          <h3 className="card-title">Secure Portal</h3>
          
          <form onSubmit={handleSubmit} className="premium-form">
            <div className="input-wrapper">
              <Mail className="field-icon" size={18} />
              <input
                type="email"
                name="email"
                placeholder="Client Email"
                onChange={handleChange}
                required
              />
            </div>

            <div className="input-wrapper">
              <Lock className="field-icon" size={18} />
              <input
                type={showPassword ? "text" : "password"}
                name="password"
                placeholder="Access Code"
                onChange={handleChange}
                required
              />
              <button 
                type="button" 
                className="toggle-eye" 
                onClick={() => setShowPassword(!showPassword)}
              >
                {showPassword ? <EyeOff size={18} /> : <Eye size={18} />}
              </button>
            </div>

            <button className={`auth-btn ${isLoading ? "loading" : ""}`} disabled={isLoading}>
              {isLoading ? (
                <span className="loader"></span>
              ) : (
                <>
                  AUTHORIZE ACCESS <ChevronRight size={18} />
                </>
              )}
            </button>
          </form>

          <div className="card-footer">
            <p>Don't have an account? <a href="/signup">Create Account</a></p>
          </div>
        </div>
        
        <div className="security-note">
          Official Secure Login • © 2024 Premium Bank of India
        </div>
      </div>
    </div>
  );
}

export default Login;