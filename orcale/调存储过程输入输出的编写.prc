create or replace procedure p_inAndOn(in_cname in T_SYS_CITY.CNAME%type,o_pro out T_SYS_CITY.PROVINCEID%type) as
 

begin

  --≤È—Ø±Ì

  select  provinceid 
    into o_pro 
    from T_SYS_CITY
   where CNAME = in_cname;

 

end p_inAndOn;
/
