PL/SQL Developer Test script 3.0
10
-- Created on 2019/10/20 by TOBILL 
declare 
  --�����������ܴ洢�����е��������
   v_pro  T_SYS_CITY.PROVINCEID%type;
begin
  -- Test statements here
  p_inAndon(999,v_pro);
  
  dbms_output.put_line(v_pro);
end;
0
0
