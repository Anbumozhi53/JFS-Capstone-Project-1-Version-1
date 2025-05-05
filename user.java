@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role; // "USER" or "ADMIN"
    // getters and setters
}

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
            .antMatchers("/api/register", "/api/login").permitAll()
            .anyRequest().authenticated();
    }
}


public String generateToken(Authentication authentication) {
    return Jwts.builder()
               .setSubject(authentication.getName())
               .setIssuedAt(new Date())
               .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_TIME))
               .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
               .compact();
}
